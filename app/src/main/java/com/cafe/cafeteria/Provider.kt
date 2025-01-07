package com.cafe.cafeteria

import com.cafe.cafeteria.Models.BegudesModel
import com.cafe.cafeteria.Models.MenjarModel
import com.cafe.cafeteria.Models.PostresModel

class Provider {
    companion object {

        val Menjars: List<MenjarModel> = listOf(
            MenjarModel("Macarrons", 10),
            MenjarModel("Arroç a la cubana", 6),
            MenjarModel("Ensalada", 5),
            MenjarModel("Spaghetti",8),
            MenjarModel("Llegums",13),
            MenjarModel("Guisants",12)
        )

        val Begudes: List<BegudesModel> = listOf(
            BegudesModel("Aigua",1.5),
            BegudesModel("Vi", 10),
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