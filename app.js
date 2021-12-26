const express = require('express');
const mongo = require('mongoose');
const app = express();
mongo.connect('mongodb://localhost/test_mongo',(err)=>{
 if(err){
   console.log(`Error = ${err} `);
 }
 console.log('Connected');
});
const User  = require('./User');
const user = new User();
app.use(express.json());
app.post('/api/data',(req,res)=>{
User.find({UserMail : req.body.UserMail},(error , result)=>{
if(result.length==0){
  user.UserName = req.body.UserName; 
  user.UserMail = req.body.UserMail;
  user.NumberTel = req.body.NumberTel;
  user.Password = req.body.Password; 
  user.save((error,result)=>{
  if(error){
    console.log(`Error is : ${error} `);
  }else{
    console.log('The result ' + result);
    res.send('');  
}
});
}else{
  res.send("Email is not valid ");
}
});
});
app.get('/api/data',(req,res)=>{
User.find({},(error,result)=>{
if(error){
  res.status(400).send(error);
}else{
  res.send(result);
}
});
});
app.get('/api/data/:UserMail/:Password',(req,res)=>{
  const find1 = req.params.UserMail;
  const find2 = req.params.Password;
User.find({UserMail : find1 , Password : find2},(error,result)=>{
  if(error){
    console.log(`Error is = ${error}`);
  }
  else{
  if(result.length===0){
    res.send('not found');
  }
  else
  {
    res.send(result[0]);
    console.log('The Result Login is ' + result[0]);
  }
}
});
});
app.delete('/api/data/:UserName',(req,res)=>{
    User.deleteOne({UserName:req.params.UserName},(error,doc)=>{
      if(error){
        res.status(400).send("Error in UserName");
        return;
      }
      res.status(200).send('GoooD');
    }); 
});
app.listen(3000);