import { Contact } from "./contact.interface";

export class ContactFactory{
    public static createcontact():Contact{
        return {
            firstname:"",
            lastname:"",
            email:"",
            tel:"",
            message:"",
        }
    }
}