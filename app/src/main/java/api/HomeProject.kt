package api

import java.io.Serializable

class HomeProject : ArrayList<HomeProjectItem>()

data class HomeProjectItem(
    val groupName: String,
    val projectNo: Int,
    val projectTitle: String,
    val projectType: Int,
    val semester: String
): Serializable