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
    offerCreatedDate: string;
    offerModifiedDate: string;
    //employee: Employee[];
}