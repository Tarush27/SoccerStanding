SoccerStanding is an android app which displays the best soccer teams all over the world.
The main motive of building this app is to demonstrate one of the recommended architectures in android i.e. MVVM and inside this,
what, why and how repository pattern plays a very vital role.
So, whatever teams list we are able to see as soon as the app opens, client(app) requests an api call which gets triggered, 
request is then sent to the server and once received information of teams as response , it gets stored in a repository class and
then it gets passed to the view model and activity. 
Hence, repository class is used to fetch information either from a database or remote.
This is how client server architecture works.

Following components used:
1. activity
2. View binding
3. MVVM
4. Kotlin
5. Clean architecture
6. Rest api - Retrofit


https://user-images.githubusercontent.com/51998612/224488524-b15197f9-5fe7-49bc-babf-4b5a3af9d05c.mp4

