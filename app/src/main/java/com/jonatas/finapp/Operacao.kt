package com.jonatas.finapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Operacao(
    val descricao: String,
    val valor: Double,
    val tipo: String
): Parcelable
