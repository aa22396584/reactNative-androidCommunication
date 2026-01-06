import React, { useState, useEffect } from 'react';
import {
  StyleSheet,
  Text,
  View,
  Dimensions,
  DeviceEventEmitter
} from 'react-native';

const Communication3 = () => {
  const [info, setInfo] = useState("等待原生訊息...");

  useEffect(() => {
    const subscription = DeviceEventEmitter.addListener('mEventName', (params) => {
      setInfo(params);
    });

    return () => {
      subscription.remove();
    };
  }, []);

  return (
    <View style={styles.container}>
      <View style={styles.glassCard}>
        <Text style={styles.label}>Incoming Native Message</Text>
        <Text style={styles.info}>{info}</Text>
      </View>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 20,
    justifyContent: 'center',
  },
  glassCard: {
    backgroundColor: 'rgba(3, 218, 197, 0.1)',
    borderWidth: 1,
    borderColor: '#03DAC5',
    borderRadius: 20,
    padding: 24,
    alignItems: 'center'
  },
  label: {
    fontSize: 12,
    color: '#03DAC5',
    fontWeight: 'bold',
    marginBottom: 8,
    textTransform: 'uppercase'
  },
  info: {
    fontSize: 16,
    color: '#212121',
    fontWeight: '500',
    textAlign: 'center'
  }
});

export default Communication3;