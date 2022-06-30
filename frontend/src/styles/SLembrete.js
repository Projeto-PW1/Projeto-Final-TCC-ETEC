import { StyleSheet } from "react-native";

const styles = StyleSheet.create({
  container: {
    height: '100%',
    width: '100%',
    justifyContent: 'center',
    alignItems: 'center',
  },
  botaoTop: {
    justifyContent: "center",
    backgroundColor: "#fae278",
    alignSelf: "flex-start",
    marginLeft: 20,
    borderRadius: 10,
    padding: 14,
    elevation: 2,
  },
  title: {
    fontSize: 25,
    alignSelf: "flex-start",
    fontWeight: "700",
    marginLeft: 25,
    color: "black",
    marginTop: 40,
  },
  text: {
    fontWeight: "600",
    color: "black",
    fontSize: 18,
    marginTop: 16,
    alignSelf: "flex-start",
  },
  textN: {
    fontWeight: "600",
    color: "black",
    fontSize: 18,
    marginTop: 35,
    alignSelf: "flex-start",
    marginLeft: 12
  },
  text3: {
    fontWeight: "600",
    color: "black",
    fontSize: 18,
    alignSelf: "flex-start",
  },
  text2: {
    fontSize: 15,
    fontWeight: '700'
  },
  view0: {
    marginTop: 3,
    flexDirection: "row",
    alignItems: "center",
    backgroundColor: "white",
    borderRadius: 18,
    paddingLeft: 8,
    alignSelf: "center",
    elevation: 1,
  },
  view02: {
    marginTop: 3,
    flexDirection: "row",
    alignItems: "center",
    backgroundColor: "white",
    borderRadius: 18,
    paddingLeft: 8,
    marginBottom: 0,
    elevation: 1
  },
  input: {
    width: 280,
    padding: 12,
    borderRadius: 15,
  },
  inputError: {
    fontSize: 13,
    alignSelf: 'flex-start',
    color: '#ff375b',
    marginBottom: 5,
  },
  scroll: {
    width: '100%',
    height: '100%'
  },
  botao: {
    backgroundColor: "#fae278",
    padding: 16,
    width: 140,
    alignItems: "center",
    borderRadius: 11,
    elevation: 1,
    alignSelf: "center",
  },
  botao2: {
    backgroundColor: "#fae278",
    padding: 13,
    alignItems: "center",
    borderRadius: 11,
    elevation: 1,
    alignSelf: "center",
    marginHorizontal: 10,
  },
  container2: {
    width: '100%',
    borderRadius: 25,
    paddingVertical: 30,
  },
  view03: {
    alignSelf: 'center',
    alignItems: 'flex-start',
  },
});

export default styles;
