import { Category } from "./category";
import { Employee } from "./employee";

export interface Offer{
    offerId: number;
    offerTitle: string;
    offerDescription: string;
    offerLikes: number;
    offerActive: boolean;
    offerOpenedDate: string;
    offerEngagedDate: string;
    offerClosedDate: string;
    offerPrice: number;
    offerNegotiable: boolean;
    employee: Employee;
    category: Category;
    employeeEngage: number;
}