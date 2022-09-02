const mongoose = require('mongoose');
const fs = require('fs');
const path = require('path')
const {promisify} = require('util');

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

PostSchema.pre('remove', function(){
   if(process.env.STORAGE_TYPE = 'local'){
         return promisify(fs.unlink)(path.resolve(__dirname, '..', '..', 'tmp', 'uploads', this.key))
   }
})


// se eu tiver em ambiente de producao, n vai enxergar esse localhost:3000 

module.exports = mongoose.model('Post', PostSchema);