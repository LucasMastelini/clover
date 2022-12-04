const mongoose = require('mongoose');
const fs = require('fs');
const path = require('path')
const {promisify} = require('util');
const aws = require('aws-sdk');

const s3 = new aws.S3();



const PostSchema = new mongoose.Schema({
   name: String,
   size: Number,
   key: String,
   url: String,
   createdAt:{
    type: Date,
    default: Date.now,
   },
});


PostSchema.pre('save', function(){
    if(!this.url){
      this.url = `${process.env.APP_URL}/files/${this.key}`;
    }
});

/*
PostSchema.pre('remove', function(){
   if(process.env.STORAGE_TYPE = 'local'){
         return promisify(fs.unlink)(path.resolve(__dirname, '..', '..', 'tmp', 'uploads', this.key))
   }
})
*/

PostSchema.pre('remove', function(){
   if(process.env.STORAGE_TYPE = 's3'){
        return s3.deleteObject({
         Bucket: 'uploadclover2022',
         Key: this.key,
        }).promise()
   } else {

   }
})




// se eu tiver em ambiente de producao, n vai enxergar esse localhost:3000 

module.exports = mongoose.model('Post', PostSchema);