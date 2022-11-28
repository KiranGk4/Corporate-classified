import { EmployeeDetails } from "./employee-details";
import { Offer } from "./offer";

export interface Employee{
    employeeId: number;
    employeeEmail: string;
    employeeDetails: EmployeeDetails;
    offerSet: Offer[];
}