package de.rki.coronawarnapp.datadonation.analytics.modules.risklevelhistory

import de.rki.coronawarnapp.datadonation.analytics.modules.DonorModule
import de.rki.coronawarnapp.server.protocols.internal.ppdd.PpaData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RiskLevelHistoryChangesDonor @Inject constructor() : DonorModule {

    override suspend fun beginDonation(request: DonorModule.Request): DonorModule.Contribution {
        // TODO
        return object : DonorModule.Contribution {
            override suspend fun injectData(protobufContainer: PpaData.PPADataAndroid.Builder) {
                // TODO
            }

            override suspend fun finishDonation(successful: Boolean) {
                // TODO
            }
        }
    }
}
