# PeopleCounter

 I decided to choose an MVVM (Model, View, ViewModel) architecture pattern. I picked this design pattern because 
 it creates an easy to use solution when faced with the issue of keeping track of the UI state when the phone is rotated.  
 The view is kept free of all business logic and checks with the ViewModel on how to update the UI accordingly. 
 The counters live in the ViewModel for the View to have access to them, and they also exist in the local storage. 
 The ViewModel gets called when the user interacts with the screen, and it will update the values the UI uses 
 and the two different counters that are stored locally on the phone. In order to update the counters stored locally,
 the ViewModel calls on the Model to take care of that. The Model updates the two counters as needed when the user
 interacts with the plus and minus buttons, as well as initializes the two counters when the app first starts.

For the issue of keeping track of the total and current people count even through killing the app, it means that
we need a way to save the data in order to refer to it upon startup. I could either use shared preferences or use
an actual database, such as Realm or Room. I decided to usethe shared preferences based on the fact that the values
I had to store were only two Integers and not a complex object or a large number of integers or other values. 

For the issue of storing the keys used to access the shared preferences, I decided to create a Constants class 
and store the Keys there. I use it as a utility file where I can keep any important constant values that I would 
need to use throughout the app. If I decided to store these keys in the strings.xml file it would then require a 
context in order to access them, which other files may not necessarily have
