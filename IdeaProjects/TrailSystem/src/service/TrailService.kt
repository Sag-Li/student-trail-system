package service

import model.Trail

class TrailService {

    private val trails = mutableListOf<Trail>()

    fun registerTrail(trail: Trail): Boolean {

        if (trails.any { it.id == trail.id }) {
            return false
        }

        trails.add(trail)

        return true
    }

    fun listTrails(): List<Trail> {
        return trails.toList()
    }

    fun findTrailById(id: Int): Trail? {
        return trails.find { it.id == id }
    }
}