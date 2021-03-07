import {UserType} from './userType';

export class User {
  id: number;
  firstName: string;
  lastName: string;
  email: string;
  imgUrl: string;
  userType: UserType;
  constructor() {
  }
}
