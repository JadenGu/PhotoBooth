PhotoBooth
================



Introduction
--------------
A small sample app which contains two main functions:

* View taken photos locally.
* Take photo and save it locally with name and create time.



App Structure
----------------

* MainActivity is a list based layout, displaying taken photos as grid.

* FAB takes the action of taking photos.

* When photo is taken, displaying a bottom dialog for user to input the name. (Use 'timestamp' as name if it's skipped)

* Redirect to detail page when clicking each photo item.



Code Architecture
---------------------

* Language: Kotlin
* App structure: Activity <---> ViewModel <---> Resposity(Room)



Set up & Run
---------------
* Android Studio 3.0+
* Download the project and open with Android Studio
* Compile and run

What's to improve
---------------------
* Could separate files into more detailed packages.
* Some code snippets could be written out of the activity class, like the 'BottomDialog', which could be better at an utility class.
