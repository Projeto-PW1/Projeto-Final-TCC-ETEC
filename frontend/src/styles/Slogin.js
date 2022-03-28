import {StyleSheet} from 'react-native';
import { textDecorationColor } from 'react-native/Libraries/Components/View/ReactNativeStyleAttributes';

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
  container2: {
    flex: 0.5,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#fffceb',
    width: '83%',
    borderRadius: 25,
    elevation: 3,

  },
  text:{
    color: '#626262',
    
  },
  title: {
      fontSize: 25,
      margin: 25,
      color: '#f9dc5c',
      fontWeight: '700',
      textShadowRadius: 2,
      textShadowColor: "#fae588"
  },
  input: {
      backgroundColor: 'white',
      borderRadius: 10,
      width: 250,
      padding: 10,
      marginTop: 10,
      elevation: 2,
  },
  botao: {
      backgroundColor: '#f9dc5c',
      padding: 13,
      margin: 27,
      width: 110,
      alignItems: 'center',
      borderRadius: 11,
      elevation: 1,
  },
  image: {
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
    width: '100%',
    height: '100%'
  },

//STYLES CADASTRO
container2R: {
  flex: 0.7,
  justifyContent: 'center',
  alignItems: 'center',
  backgroundColor: '#fffceb',
  width: '83%',
  borderRadius: 25,
  elevation: 20,
  shadowColor: '#f9dc5c',
  
},
botao2: {
  backgroundColor: 'white',
  padding: 5,
  margin: 5,
  width: 150,
  alignItems: 'center',
  borderRadius: 11,
  elevation: 1,
},
});

export default styles;