import { StyleSheet } from "react-native";

const styles = StyleSheet.create({
  container: {
    justifyContent: "center",
    alignItems: "center",
  },
  image: {
    justifyContent: "center",
    alignItems: "center",
    width: "100%",
    height: "100%",
  },
  title: {
    fontSize: 29,
    alignSelf: "flex-start",
    fontWeight: "700",
    marginLeft: 25,
    color: "black",
  },
  frasesView: {
    flex: 0.37,
    justifyContent: "center",
    alignItems: "center",
    alignSelf: "center",
    backgroundColor: "#fae278",
    margin: 25,
    padding: 5,
    borderRadius: 30,
    elevation: 1,
  },
  textFrases: {
    color: "black",
    padding: 15,
    fontSize: 15,
    fontWeight: "700",
  },
  text: {
    fontSize: 18,
    fontWeight: "700",
    color: "black",
    marginLeft: 25,
    alignSelf: "flex-start",
  },
  textList: {
    fontSize: 14,
    fontWeight: "600",
    color: "black",
  },
  containerList: {
    flex: 0.4,
    justifyContent: "center",
    alignItems: "center",
    width: "82%",
    borderRadius: 30,
    marginTop: 10,
    backgroundColor: 'white'
  },
  viewList: {
    alignItems: "center",
    width: 270,
    margin: 5,
    backgroundColor: "white",
    padding: 5,
    borderRadius: 8,
    flexDirection: "row",
  },
  viewRemedio: {
    alignSelf: "center",
  },
  botaoIcon: {
    alignSelf: "center",
    marginEnd: 10,
  },
  botaoCheck: {
    alignSelf: "flex-end",
    marginEnd: 10,
  },
  viewCheck: {
    paddingLeft: 75,
    alignSelf: 'center'
  },

  //Style icons Bottom
  view1: {
    height: "100%",
    width: "100%",
  },
  row: {
    alignItems: "center",
    flexDirection: "row",
    alignSelf: "center",
    justifyContent: "flex-end",
    marginTop: 10,
  },
  iconRow: {
    marginRight: 10,
  },
  //Menu
  viewBotao: {
    flex: 1,
    justifyContent: "flex-start",
    alignItems: "center",
  },
  containerMenu: {
    flex: 1,
    justifyContent: "space-evenly",
    alignItems: "center",
    marginVertical: 120,
  },
  botaoVoltar: {
    justifyContent: "center",
    backgroundColor: "#fae278",
    marginTop: 40,
    marginRight: 10,
    borderRadius: 10,
    padding: 11,
    alignSelf: "flex-end",
  },
  botaoTelas: {
    flexDirection: "row",
    alignItems: "center",
    justifyContent: "center",
    backgroundColor: "white",
    borderRadius: 10,
    padding: 11,
    alignSelf: "center",
  },
  textBotao: {
    fontSize: 17,
    fontWeight: "700",
    paddingRight: 10,
  },
  textBotao2: {
    fontSize: 17,
    fontWeight: "700",
  },
  botaoSair: {
    width: 220,
    justifyContent: "center",
    alignItems: "center",
    backgroundColor: "#fae278",
    borderRadius: 10,
    padding: 11,
    alignSelf: "center",
  },
  iconMenu: {
    paddingRight: 6,
  },
});

export default styles;
