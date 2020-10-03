/**
 * Paciente.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {

     nombre:{
    type: 'string',
  },
  edad:{
    type: 'string',
  },
  tipoSangre:{
    type: 'string',

  }, cedula:{
    type: 'string',

  },

  doctor:{
    type: 'string',

  },
  latitud :{
    type: 'string',

  },
  longitud:{
    type: 'string',

  },
  url:{
    type: 'string',

  },
  urlImagen:{
    type: 'string',

  },

  },

};

