package api

class ProjectResponse : ArrayList<ProjectResponseItem>()

data class ProjectResponseItem(
    var Advisor: String,
    var Committees: String,
    var Description: String,
    var External_exposure: String,
    var Grade: String,
    var No_: Int,
    var Required_skills: Any,
    var Semester: String,
    var Senior_type: Int,
    var Student_list: String,
    var Team: String,
    var Team_skills: String,
    var Title: String

//    var ProjectResponse: List<ProjectResponseItem>
)
