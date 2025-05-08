package com.assignment.onlinescoreupdateapp.domain.usecases

import com.assignment.onlinescoreupdateapp.domain.repositories.FixtureRepository
import javax.inject.Inject

class GetFixturesUseCase @Inject constructor(private val repository: FixtureRepository) {
    suspend operator fun invoke() = repository.getFixtures()
}