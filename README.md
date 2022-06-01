Activity lifecycle

The Activity lifecycle and state app looks and behaves roughly the same as it did in the last codelab. It contains two Activity implementations and gives the user the ability to send between them<br> <br>
<img src="/Screenshots/activity lifecycle.gif" width="190" height="350"/>

<br>#message received<br>
<img src="/Screenshots/received.png" width="190" height="350"/><br>
<br>#message reply<br>
<img src="/Screenshots/reply.png" width="190" height="350"/><br>


<b> Coding challenge</b><br>
layout challenge

A simple shopping-list app with a main activity for the list the user is building, and a second activity for a list of common shopping items. an Intent to pass information from one Activity to another. Current state of the shopping list is saved when the user rotates the device
<img src="/Screenshots/activity lifecycle challenge.gif" width="390" height="550"/><br>

<img src="/Screenshots/mainactivity.png" width="490" height="350"/>

<b>Homework</b><br>
An app with a layout that holds a counter TextView, a Button to increment the counter, and an EditText Implement onSaveInstanceState() to save the current state of the app.<br>
<img src="/Screenshots/counterhomework.png" width="290" height="450"/><br>

<img src="/Screenshots/activity lifecycle homework.gif" width="390" height="550"/>



Question 1

If you run the homework app before implementing onSaveInstanceState(), what happens if you rotate the device?
-> The counter is reset to 0, but the contents of the EditText is preserved.

Question 2

What Activity lifecycle methods are called when a device-configuration change (such as rotation) occurs?
-> Android shuts down your Activity by calling onPause(), onStop(), and onDestroy(), and then starts it over again, calling onCreate(), onStart(), and onResume().

Question 3

When in the Activity lifecycle is onSaveInstanceState() called?
-> onSaveInstanceState() is called before the onStop() method.

Question 4

Which Activity lifecycle methods are best to use for saving data before the Activity is finished or destroyed?
-> onPause() or onStop()
