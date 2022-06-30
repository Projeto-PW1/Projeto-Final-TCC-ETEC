import React, { useState } from "react";
import {
  StyleSheet,
  View,
  Text,
  Platform,
  TouchableOpacity,
} from "react-native";

//Importando Ícones do MaterialIcons do react-native-vector-iconss
import Icon from "react-native-vector-icons/MaterialCommunityIcons";

import DateTimePicker from "@react-native-community/datetimepicker";

const DatePicker = () => {
  const [isPickerDateShow, setIsPickerDateShow] = useState(false);
  const [isPickerTimeShow, setIsPickerTimeShow] = useState(false);
  const [date, setDate] = useState(new Date(Date.now()));

  const showPickerDate = () => {
    setIsPickerDateShow(true);
  };

  const showPickerTime = () => {
    setIsPickerTimeShow(true);
  };

  const onChange = (event, value) => {
    setDate(value);
    if (Platform.OS === "android") {
      setIsPickerDateShow(false);
    }
  };

  const onChangeTime = (event, value) => {
    setDate(value);
    if (Platform.OS === "android") {
      setIsPickerTimeShow(false);
    }
  };
  //let formatTeste = `${date.toLocaleDateString('pt-BR')}`
  let formatDate = `${date.getDate()}/${
    date.getMonth() + 1
  }/${date.getFullYear()}`;
  let formatTime = `${date.getHours()}:${date.getMinutes()}`;

  return (
    <View style={styles.container}>
      {/* The button that used to trigger the date picker */}
      {!isPickerDateShow && (
        <View style={styles.btnContainer}>
          <TouchableOpacity style={styles.botao} onPress={showPickerDate}>
            <Icon name="calendar-today" color="black" size={30} />
            <Text style={styles.text2}>Data: {formatDate}</Text>
          </TouchableOpacity>
        </View>
      )}

      {!isPickerTimeShow && (
        <View style={styles.btnContainer}>
          <TouchableOpacity style={styles.botao} onPress={showPickerTime}>
            <Icon name="clock" color="black" size={30} />
            <Text style={styles.text2}>Horário: {formatTime}</Text>
          </TouchableOpacity>
        </View>
      )}

      {/* The date picker */}
      {isPickerDateShow && (
        <DateTimePicker
          value={date}
          mode={"date"}
          display={Platform.OS === "ios" ? "spinner" : "default"}
          is24Hour={true}
          onChange={onChange}
          style={styles.datePicker}
        />
      )}

      {/* The date picker */}
      {isPickerTimeShow && (
        <DateTimePicker
          value={date}
          mode={"time"}
          display={Platform.OS === "ios" ? "spinner" : "default"}
          is24Hour={true}
          onChange={onChangeTime}
          style={styles.datePicker}
        />
      )}
    </View>
  );
};

// Kindacode.com
// just add some styles to make our app look more beautiful
// This is not the focus of this article
const styles = StyleSheet.create({
  container: {
    alignItems: "center",
    justifyContent: "center",
  },
  pickedDateContainer: {
    padding: 20,
    backgroundColor: "#eee",
    borderRadius: 10,
  },
  pickedDate: {
    fontSize: 18,
    color: "black",
  },
  btnContainer: {
    padding: 10,
  },
  // This only works on iOS
  datePicker: {
    width: 320,
    height: 260,
    display: "flex",
    justifyContent: "center",
    alignItems: "flex-start",
  },
  botao: {
    flexDirection: "row",
    width: 320,
    padding: 12,
    backgroundColor: "white",
    borderRadius: 15,
    alignItems: "center",
    elevation: 1
  },
  text: {
    fontWeight: "600",
    color: "black",
    fontSize: 15,
    alignSelf: "center",
  },
  text2: {
    marginLeft: 12,
    color: "grey",
    alignSelf: "center",
  },
});

export default DatePicker;
