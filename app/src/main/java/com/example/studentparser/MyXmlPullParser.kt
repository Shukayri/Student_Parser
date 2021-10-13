package com.example.studentparser


import org.xmlpull.v1.XmlPullParserException
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.io.IOException
import java.io.InputStream

class MyXmlPullParserHandler {
    private val stud = ArrayList<Students>()
    private var text: String? = null

    private var studentId = 0
    private var studentName = ""
    private var studentMark = 0

    fun parse(inputStream: InputStream): List<Students> {
        try {
            val factory = XmlPullParserFactory.newInstance()
            val parser = factory.newPullParser()
            parser.setInput(inputStream, null)
            var eventType = parser.eventType
            while (eventType != XmlPullParser.END_DOCUMENT) {
                val tagName = parser.name
                when (eventType) {
                    XmlPullParser.TEXT -> text = parser.text
                    XmlPullParser.END_TAG -> when {
                        tagName.equals("id", ignoreCase = true) -> {
                            studentId = text!!.toInt()
                        }
                        tagName.equals("name", ignoreCase = true) -> {
                            studentName = text.toString()
                        }
                        tagName.equals("marks", ignoreCase = true) -> {
                            studentMark = text!!.toInt()
                        }
                        else -> stud.add(Students(studentId, studentName , studentMark ))
                    }

                    else -> {
                    }
                }
                eventType = parser.next()
            }

        } catch (e: XmlPullParserException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return stud
    }
}