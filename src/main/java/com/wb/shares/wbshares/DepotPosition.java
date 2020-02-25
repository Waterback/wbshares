package com.wb.shares.wbshares;

import java.time.Instant;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
class DepotPosition {
  @Id String id;
  @Indexed PositionType type;
  @Indexed String name;
  @Indexed List<PositionValue> positionValues;
  Double currentSum;

  public enum PositionType {
    SHARE,
    SHAREFOND,
    BONDFOND,
    REALTYFOND,
    CASH
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  public static class PositionValue {
    Instant date;
    Double amount;
    Double price;
    Double sum;
  }

}
