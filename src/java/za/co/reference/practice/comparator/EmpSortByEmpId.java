package za.co.reference.practice.comparator;

import java.util.Comparator;

public class EmpSortByEmpId implements Comparator<Employee>{

	/*
	 * If o1's empId is greater than o2's empId, then o1 is greater than o2
	 */
	@Override
	public int compare(Employee o1, Employee o2){
		return o1.getEmpId() - o2.getEmpId();
	}

}
