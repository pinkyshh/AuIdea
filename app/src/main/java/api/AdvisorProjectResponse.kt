package api

class AdvisorProjectResponse : ArrayList<AdvisorProjectResponseItem>()

data class AdvisorProjectResponseItem(
    val advisorId: Int,
    val advisorImage: String,
    val advisorName: String,
    val projTeam: String,
    val projTitle: String,
    val projNo: Int,
    val projSemester: String,
    val projType: Int
)
