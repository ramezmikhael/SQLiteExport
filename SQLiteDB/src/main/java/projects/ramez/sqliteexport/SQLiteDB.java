package projects.ramez.sqliteexport;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * Created by Ramez on 12/10/2017.
 */

public class SQLiteDB {

    private Context mContext;

    private SQLiteDB(Context context) {
        mContext = context;
    }

    public static SQLiteDB with(Context context) {
        return new SQLiteDB(context);
    }

    public boolean export(String dbName) {

        return saveDbToDownloadsFolder(dbName);
    }

    private boolean saveDbToDownloadsFolder(String dbName) {
        File backupDB = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                dbName);
        File currentDB = mContext.getDatabasePath(dbName);
        if (currentDB.exists()) {
            FileChannel src = null;
            try {
                src = new FileInputStream(currentDB).getChannel();
                FileChannel dst = new FileOutputStream(backupDB).getChannel();
                dst.transferFrom(src, 0, src.size());
                src.close();
                dst.close();

                return true;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return false;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }

        return false;
    }
}

