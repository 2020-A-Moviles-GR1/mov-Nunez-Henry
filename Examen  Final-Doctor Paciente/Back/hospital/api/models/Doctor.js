/**
 * Doctor.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {



    attributes: {

      nombre:{
        type:'string',
        required:true, // Por defecto es false
      },
      edad:{
        type: 'string',
  
      },
      tipoSangre:{
        type:'string',
  
      },
      peso:{
        type:'string',
  
      },
  
     paciente:{
        type:'string',
      }
  },


}

