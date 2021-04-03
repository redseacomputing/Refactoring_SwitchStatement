package switchstatement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InsuranceQuoteTest {

    @Test
    void motorRiskShouldReturnHigh_RiskOnAgeUnder25() {
        InsuranceQuote quote = getInsuranceQuote(0, 18);
        assertEquals(RiskFactor.HIGH_RISK, quote.calculateMotoristRisk());
    }

    @Test
    void motorRiskShouldReturnHigh_RiskOnInsurancePointsGreaterThan3AndAgeGreaterThan25() {
        InsuranceQuote quote = getInsuranceQuote(4, 30);
        assertEquals(RiskFactor.HIGH_RISK, quote.calculateMotoristRisk());
    }
    @Test
    void motorRiskShouldReturnModerate_RiskOnInsurancePointsGreaterThan3() {
        InsuranceQuote quote = getInsuranceQuote(1, 30);
        assertEquals(RiskFactor.MODERATE_RISK, quote.calculateMotoristRisk());
    }

    @Test
    void motorRiskShouldReturnLow_RiskWithZeroInsurancePointsAndAgeGreaterThan25() {
        InsuranceQuote quote = getInsuranceQuote(0, 30);
        assertEquals(RiskFactor.LOW_RISK, quote.calculateMotoristRisk());
    }

    @Test
    void premiumInsuranceShouldReturn2WithLowRisk() {
        InsuranceQuote quote = getInsuranceQuote(0, 30);
        assertEquals(2,quote.calculateInsurancePremium(100));
    }

    @Test
    void premiumInsuranceShouldReturn4WithModerateRisk() {
        InsuranceQuote quote = getInsuranceQuote(1, 30);
        assertEquals(4,quote.calculateInsurancePremium(100));
    }

    @Test
    void premiumInsuranceShouldReturn6WithHighRisk() {
        InsuranceQuote quote = getInsuranceQuote(4, 30);
        assertEquals(6,quote.calculateInsurancePremium(100));
    }

    private InsuranceQuote getInsuranceQuote(int insurancePoints, int age) {
        Motorist driver = getMotorist(insurancePoints, age);
        return new InsuranceQuote(driver);
    }

    private Motorist getMotorist(int insurancePoints, int age) {
        return new Motorist("Mr.", "John", "Doe", age, insurancePoints);
    }
}