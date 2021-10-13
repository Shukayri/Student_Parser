package com.example.studentparser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private lateinit var stud: List<Students>
    private lateinit var studentrv: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        studentrv = ArrayList()

        rvStudents.adapter = MyAdapter(this, studentrv)
        rvStudents.layoutManager = LinearLayoutManager(this)



        try{
            val parser = MyXmlPullParserHandler()
            val iStream = assets.open("studentdetails.xml")
            stud = parser.parse(iStream)

            var text = ""
            for(student in stud){
                text += "${student.name} - ${student.marks}\n"
            }
            studentrv.add(text)
            rvStudents.adapter?.notifyDataSetChanged()
        }catch (e: IOException) {
            println("ISSUE: $e")
        }
    }
}