package com.cafe.cafeteria

import com.cafe.cafeteria.Models.BegudesModel
import com.cafe.cafeteria.Models.MenjarModel
import com.cafe.cafeteria.Models.PostresModel

class Provider {
    companion object {

        fun getMenjarNames(): List<String> {
            return Menjars.map { it.menjar }
        }

        fun getBegudesNames(): List<String> {
            return Begudes.map { it.beguda }
        }

        fun getPostresNames(): List<String> {
            return Postres.map { it.postre }
        }

        val Menjars: List<MenjarModel> = listOf(
            MenjarModel("Macarrones", 10),
            MenjarModel("Arroz a la cubana", 6),
            MenjarModel("Ensalada", 5),
            MenjarModel("Spaghetti",8),
            MenjarModel("Lentejas",13),
            MenjarModel("Guisantes",12)
        )

        val Begudes: List<BegudesModel> = listOf(
            BegudesModel("Agua",1.5),
            BegudesModel("Vino", 10),
            BegudesModel("Nestik", 2.5),
            BegudesModel("Cocacola", 2),
            BegudesModel("Fanta", 2.5)
        )

        val Postres: List<PostresModel> = listOf(
            PostresModel("Gelat", 10),
            PostresModel("Arroç amb llet", 6),
            PostresModel("Tarta amb nata", 5),
            PostresModel("Tiramisu",8),
        )
    }
}