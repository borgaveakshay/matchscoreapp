package com.assignment.onlinescoreupdateapp.domain.usecases

import com.assignment.onlinescoreupdateapp.domain.repositories.FixtureRepository
import javax.inject.Inject

class GetFixtureDetailsUseCase @Inject constructor(
    private val fixtureRepository: FixtureRepository
) {
    suspend operator fun invoke() = fixtureRepository.getFixtureDetails()

}