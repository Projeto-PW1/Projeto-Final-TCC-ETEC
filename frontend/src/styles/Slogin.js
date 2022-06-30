import { StyleSheet } from "react-native";

const styles = StyleSheet.create({
  container: {
    width: '100%',
    height: '100%',
    justifyContent: "center",
    alignItems: "center",
  },
  container2: {
    justifyContent: "center",
    alignItems: "center",
    backgroundColor: "white",
    width: "90%",
    borderRadius: 25,
    elevation: 3,
    padding: 10,
    marginTop: 20,
  },
  text: {
    color: "#2a2a2a",
    fontSize: 15,
    fontWeight: '700'
  },
  title: {
    fontSize: 30,
    margin: 25,
    marginTop: 30,
    color: "#2a2a2a",
    fontWeight: "700",
    textShadowRadius: 2,
    textShadowColor: "#fae588",
    alignSelf: "center",
  },
  viewInput:{
    flexDirection: 'row',
    alignItems: 'center',
    marginHorizontal: 10,
    marginRight: 20, 
  },
  input: {
    borderRadius: 10,
    width: 250,
    padding: 10,
    marginTop: 10,
    alignSelf: "center",
  },
  inputError: {
    fontSize: 13,
    alignSelf: 'flex-start',
    color: '#ff375b',
    marginBottom: 5,
  },
  botao: {
    backgroundColor: "#fae278",
    padding: 13,
    margin: 30,
    marginBottom: 15,
    width: 280,
    alignItems: "center",
    borderRadius: 10,
    elevation: 1,
    alignSelf: "center",
  },
  image: {
    justifyContent: "center",
    alignItems: "center",
    width: "100%",
    height: "100%",
  },
  scroll: {
    width: "100%",
  },
  //botão "Não possui cadastro?"
  viewB: {
    justifyContent: "center",
    alignSelf: "center",
    margin: 5,
  },
  botao2: {
    padding: 5,
    width: 200,
    alignItems: "center",
    borderRadius: 10,
  },
  text2: {
    color: '#2a2a2a',
    fontWeight: "700",
  },

  //Botão "Esqueceu sua senha?"
  viewC: {
    justifyContent: "center",
    alignSelf: "center",
    marginBottom: 30,
  },
  botao3: {
    padding: 5,
    width: 200,
    alignItems: "center",
    borderRadius: 10,
  },
});

export default styles;