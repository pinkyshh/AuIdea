package api

class HomeProject : ArrayList<HomeProjectItem>()

data class HomeProjectItem(
    val groupName: String,
    val projectTitle: String,
    val projectType: Int,
    val semester: String
)