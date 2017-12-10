# SQLiteExport
A small Android library to export SQLite databases to the Downloads folder. This library was made as a practice for the Google-Udacity challenge for Android Developer Nanodegree.

# How To Use:
- Add the library to your Android project as a module. Currently you need to add the `SQLiteDB-release.aar` file found in `SQLiteExport/SQLiteDB/build/outputs/aar`.
- Add `<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>` to your project's Manifist file.
- Use code like the following to export a SQLite database to the device's Download Folder:
`SQLiteDB.with(this).export("database_file_name.db");`
