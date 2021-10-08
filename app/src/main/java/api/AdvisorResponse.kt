package api

class AdvisorResponse : ArrayList<AdvisorResponseItem>()

data class AdvisorResponseItem(
    val advisorId: Int,
    val advisorName:String,
    val advisorImage:String,
    val advisorSpecialty : String
)
