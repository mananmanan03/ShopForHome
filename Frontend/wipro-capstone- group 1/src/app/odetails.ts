export class Odetails {
    orderid:number;
    id:number;
    pid:number;
    pname:string;
    description:string;
    price:number;
    address:string;
    email:string;
    discount:number;
    image:string;
    datedetails:string;
    category:string;
    constructor(orderid:number,id:number,pid:number,pname:string,description:string,price:number,address:string,email:string,discount:number,image:string,datedetails:string,category:string){
        this.orderid=orderid;
        this.id=id;
        this.pid=pid;
        this.pname=pname;
        this.description=description;
        this.price=price;
        this.address=address;
        this.email=email;
        this.discount=discount;
        this.image=image;
        this.datedetails=datedetails;
        this.category=category;
    }

}