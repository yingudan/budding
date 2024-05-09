package design.strategy.normal;

/**
 * 老客户小批量
 */
public class OldCustomerFewStrategy implements Strategy {
	/**
	 * 给标准价格打八五折
	 */
	@Override
	public double getPrice(double standardPrice) {
		System.out.println("打八五折");
		return standardPrice * 0.85;
	}
}
