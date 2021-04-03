package switchstatement;

public class InsuranceQuote {

    private final Motorist motorist;

    public InsuranceQuote(Motorist motorist) {
        this.motorist = motorist;
    }

    public RiskFactor calculateMotoristRisk() {
        if (motorist.getInsurancePoints() > 3 || motorist.getAge() < 25) {
            return RiskFactor.HIGH_RISK;
        }

        if (motorist.getInsurancePoints() > 0) {
            return RiskFactor.MODERATE_RISK;
        }

        return RiskFactor.LOW_RISK;
    }

    public double calculateInsurancePremium(double insuranceValue) {
        RiskFactor riskFactor = calculateMotoristRisk();

        switch (riskFactor) {
            case LOW_RISK:
                return insuranceValue * 0.02;
            case MODERATE_RISK:
                return insuranceValue * 0.04;
            default:
                return insuranceValue * 0.06;
        }
    }
}
