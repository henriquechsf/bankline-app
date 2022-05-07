package tech.henriquedev.bankline.ui.statement

import androidx.lifecycle.ViewModel
import tech.henriquedev.bankline.data.BanklineRepository

class BankStatementViewModel : ViewModel() {

    fun findBankStatement(accountHolderId: Int) =
        BanklineRepository.findBankStatement(accountHolderId)
}