import AsyncStorage from "@react-native-async-storage/async-storage";
import React, { useEffect } from "react";

import { View, ActivityIndicator } from 'react-native';
import api from "../api/Api";
import styles from "../styles/SLoginToken";

const LoginToken = ({ navigation }) => {

   useEffect(() => {
      const loginToken = async () => {
         const token = await AsyncStorage.getItem("token");

         if (token) {
            try {
               const data = await api.get("/", {
                  headers: {
                     Authorization: `Bearer ${token}`
                  }
               }); 
               //console.log(data.data);
               navigation.navigate("Home")
            } catch (error) {
               navigation.navigate("Login");
               console.log(error);
            }
         } else {
            navigation.navigate("Login");
         }      
      }
      loginToken();
   }, []);

   return (
      <View style={styles.container}>
         <ActivityIndicator color="#fae278" size={45}/>
      </View>
   )
}

export default LoginToken;