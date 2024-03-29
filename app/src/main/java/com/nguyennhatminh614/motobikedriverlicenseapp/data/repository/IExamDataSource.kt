package com.nguyennhatminh614.motobikedriverlicenseapp.data.repository

import com.nguyennhatminh614.motobikedriverlicenseapp.data.model.Exam
import com.nguyennhatminh614.motobikedriverlicenseapp.data.model.dataconverter.questions.QuestionItemResponse
import com.nguyennhatminh614.motobikedriverlicenseapp.utils.interfaces.IResponseListener

interface IExamDataSource {
    interface Local {
        suspend fun insertNewExam(exam: Exam)
        suspend fun deleteExam(exam: Exam)
        suspend fun getAllExam(): MutableList<Exam>
        suspend fun getDetailExamByID(id: Int): Exam
        suspend fun updateExam(exam: Exam)
        suspend fun getAllExamByLicenseType(licenseType: String) : MutableList<Exam>
    }

    interface Remote {
        suspend fun getListQuestion(listener: IResponseListener<MutableList<QuestionItemResponse>>)
    }
}
