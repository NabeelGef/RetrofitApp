const mongo = require('mongoose');
const express = require('express');
const router = express();
var validateEmail = function(email) {
  var re = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
  return re.test(email)
};
 const Schema = mongo.Schema({
   UserName : {
       type : String , 
       required : true
   },
   UserMail : {
     type : String,
     required : 'Email address is required',
     validate: [validateEmail, 'Please fill a valid email address'],
      match: [/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/, 'Please fill a valid email address'],
    },
    Password : {
      type : String,
      required : true,
    },
    NumberTel : {
      type : Number , 
      required : true,
    }
 });
 module.exports = mongo.model('User',Schema);