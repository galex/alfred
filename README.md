Alfred
======

Annotation-triggered helpers for your project. Alfred at your service.


Simply add `@CheckThread` to your methods and you will automatically get the name of the Thread
your method runs in.

```java
private class CheckThreadAsyncTask extends AsyncTask<Void, Void, Void> {

    @CheckThread
    @Override protected void onPreExecute() {
        super.onPreExecute();
    }

    @CheckThread
    protected Void doInBackground(Void... params) {
        return null;
    }

    @CheckThread
    @Override protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }
}
```
```
V/Alfred  (1): CheckThread MainActivity$CheckThreadAsyncTask#onPreExecute @[MainThread]
V/Alfred  (1): CheckThread MainActivity$CheckThreadAsyncTask#doInBackground @[AsyncTask #3]
V/Alfred  (1): CheckThread MainActivity$CheckThreadAsyncTask#onPostExecute @[MainThread]
```

Every annotation helper will happen in debug builds and the annotation itself is never present in the
compiled class file for any build type. This means you can keep the annotation and check it into
source control. It has zero effect on non-debug builds.

Add it to your project today!

```groovy
buildscript {
  repositories {
    mavenCentral()
  }

  dependencies {
    classpath 'com.ubiquoid.alfred:alfred-plugin:1.0'
  }
}

apply plugin: 'com.android.application'
apply plugin: 'com.ubiquoid.alfred'
```


Local Development
-----------------

Working on this project? Here's some helpful Gradle tasks:

 * `install` - Install plugin, runtime, and annotations into local repo.
 * `cleanExample` - Clean the example project build.
 * `assembleExample` - Build the example project. Must run `install` first.
 * `installExample` - Build and install the example project debug APK onto a device.


License
--------

    Copyright 2014 Alexander Gherschon

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
