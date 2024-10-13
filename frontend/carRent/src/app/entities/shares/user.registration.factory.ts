import { UserRegistration } from "./user.registration";

export class UserRegistrationFactory{
    static createUser():UserRegistration{
        return {
            id : 0,
            email : '',
            pwd : ''
    }
}
}