# TwoWayDataBinding
Steps for generating data binding object

1) Enable Data Binding at the end of the "android" block of  the app level build.gradle file.
   
   android {
   ..........
   ..........
   ..........
   dataBinding{
   enabled true
   }
   }

3) Add layout tags as the outermost tags of the xml layout.
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
xmlns:app="http://schemas.android.com/apk/res-auto"
xmlns:tools="http://schemas.android.com/tools">
<androidx.constraintlayout.widget.ConstraintLayout
android:layout_width="match_parent"
android:layout_height="match_parent"
tools:context=".MainActivity">

..............................................
..............................................
..............................................
..............................................

</androidx.constraintlayout.widget.ConstraintLayout>
</layout>

3) Get the data binding object of the layout using DataBindingUtil.(In the Activity)
   
   class MainActivity : AppCompatActivity() {

   private lateinit var binding: ActivityMainBinding

   override fun onCreate(savedInstanceState: Bundle?) {
   super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

   }
}

4) Use properties of data binding object.
   Ids in the xml layout turns in to property names in the data binding object.

 Eg :

 <Button     android:id="@+id/control_button"

 ...................................

 ...................................

 ...................................

 />

 we can use that using property name "controlButton"

 binding.controlButton.setOnClickListener {
 startOrStopProgressBar()
 }


5) How to pass an object(data) to the xml layout and use them directly.
   In xml layout Define a variable for the object.
   
   <data>
    <variable
        name="student"
        type="com.anushka.bindingdemo3.Student" />
</data>

 In the activity, assign the data object to that defined layout variable

 class MainActivity : AppCompatActivity() {
 
 private lateinit var binding: ActivityMainBinding
 
 override fun onCreate(savedInstanceState: Bundle?) {
 
 super.onCreate(savedInstanceState)
 
 binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
 
 binding.student = getStudent()
 
 }

    private fun getStudent():Student{
        return Student(1,"Alex","alex@gmail.com")
    }
}
In xml layout   Use the properties of the object in xml view components using binding expressions.

    <TextView
    android:id="@+id/name_text"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    .............
    android:text="@{student.name}"
    .............
    .............
    .............
    app:layout_constraintVertical_bias="0.415" />
