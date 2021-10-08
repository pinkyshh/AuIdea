package api


class ProjectResponse : ArrayList<ProjectResponseItem>()

data class ProjectResponseItem(
    val projectNo: Int,
    val projectTitle: String,
    val projectDescription: String,
    val groupName: String,
    val projectType: Int,
    val groupMembers: String,
    val advisorName: String,
)

