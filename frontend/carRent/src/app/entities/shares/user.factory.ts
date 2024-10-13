import { User } from "./user.interface";


export class userFactory{
    static createUser():User{
        return {
            id : 0,
            email : '',
    }
}
}