package com.example.restapi.jsondata


import com.example.restapi.data.Device
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

fun main() {
    val json = """
        [
            {
                "id": "3",
                "name": "Apple iPhone 12 Pro Max",
                "data": {
                    "color": "Cloudy White",
                    "capacity GB": 512
                }
            },
            {
                "id": "5",
                "name": "Samsung Galaxy Z Fold2",
                "data": {
                    "price": 689.99,
                    "color": "Brown"
                }
            },
            {
                "id": "10",
                "name": "Apple iPad Mini 5th Gen",
                "data": {
                    "Capacity": "64 GB",
                    "Screen size": 7.9
                }
            }
        ]
    """.trimIndent()

    val devices = Json.decodeFromString<List<Device>>(json)

    for (device in devices) {
        println("ID: ${device.id}")
        println("Name: ${device.name}")
        println("Data:")
        for ((key, value) in device.data) {
            println("  $key: $value")
        }
        println()
    }
}
