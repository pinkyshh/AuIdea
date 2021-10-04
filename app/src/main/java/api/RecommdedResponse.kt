package api

class RecommendedResponse : ArrayList<RecommendedResponseItem>()

data class RecommendedResponseItem(
    val ranking: Int,
    val recommended_project_no_: Int,
    val target_student: Int
)